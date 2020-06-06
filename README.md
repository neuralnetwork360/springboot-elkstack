# springboot-elkstack

What is ELK ?

ELK  - ElasticSearch & Logstash & Kibana

Download :

ElasticSearch : https://www.elastic.co/downloads/elasticsearch

Logstash : https://www.elastic.co/downloads/logstash

Kibana : https://www.elastic.co/downloads/kibana

Run Elastic search : Go -> elasticsearch-7.7.0-windows-x86_64\elasticsearch-7.7.0\bin -> and do run elasticsearch.bat file in command prompt

Run logstash : Go -> logstash-7.7.0\logstash-7.7.0\bin -> and create the logstash.conf file like below and paste it in same folder and run using below command.

command -> logstash -f logstash.conf

logstash.conf File :

input {
  file {
    path => "F:/ArifWorkSpace/NeuralNetwork/Logs/*.log"
	start_position => "beginning"
	#sincedb_path => "E:/Softwares/ELK/logstash-7.7.0/logstash-7.7.0/dbfilea"
	type => "logs"
    codec => multiline {
      pattern => "^%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME}.*"
      negate => "true"
      what => "previous"
    }
  }
}
 
      
filter {
  #If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
  if [message] =~ "\tat" {
    grok {
      match => ["message", "^(\tat)"]
      add_tag => ["stacktrace"]
    }
  }
 
 grok {
    match => [ "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- \[(?<thread>[A-Za-z0-9-]+)\] [A-Za-z0-9.]*\.(?<class>[A-Za-z0-9#_]+)\s*:\s+(?<logmessage>.*)",
               "message",
               "(?<timestamp>%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME})  %{LOGLEVEL:level} %{NUMBER:pid} --- .+? :\s+(?<logmessage>.*)"
             ]
  }
 
  
  date {
    match => [ "timestamp" , "yyyy-MM-dd HH:mm:ss.SSS" ]
  }
}
 
output {
   
  stdout {
    codec => rubydebug
  }
  elasticsearch {
    hosts => ["localhost:9200"]
	index => "mobilebankingindexer"
  }
} 

------------------------------------------------------------------------------------------------------------------------------

Note : If you used custome index in logstash.conf file. Disable/Comment with # key if elasticsearch.yml file is enabled this key - action.auto_create_index


Kibana Query to view elastic record : 

Query to fetch records based on index key ---> GET /mobilebankingindexer/_search?size=100
Query to fetch all index which created in elasticsearch ----> GET /_cat/indices?v

You can also delete and check once again the index using this query ----> DELETE /mobilebankingindexer



