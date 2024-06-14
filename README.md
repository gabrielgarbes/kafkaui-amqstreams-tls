# Amq Streams com KafkaUi com TLS

Provisionando Kafka Ui dentro de um cluster Open Shift utilizando TLS como protocolo de segurança.

Antes de começar é importante mencionar que será necessário permissões de administrador no cluster para realizar os passos a seguir.

## Criando a Infraestrutura do Amq Streams

~~~
oc apply -f amqstreams/infra-amq.yaml
~~~

Esse comando irá realizar as seguintes tarefas:

* Criar um projeto com o nome amqstreams
* Criar um group operator no namespace de destino
* Criar o operator Amq Streams na versão v2.7.0-1
* Criar o kafka com 3 replicas com as seguintes portas:
  * 9092 internal, tls false
  * 9093 internal, tls true
  * 9094 external, tls true
 
Após a execução do comando ser finalizada é esperado que todas as instancias do operator estejam com o status ready.


