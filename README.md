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

## Criando o Kafka UI

O Kafka UI é uma interface gráfica de usuário para o Apache Kafka. 
Ele permite que os usuários interajam com clusters Kafka de forma mais amigável e intuitiva, facilitando tarefas como monitoramento, gerenciamento de tópicos, visualização de mensagens e administração de consumidores e produtores.

Alguns pontos da importância do Kafka UI:
- Simplifica a interação com o Kafka, eliminando a necessidade de usar a linha de comando para tarefas comuns.
- Fornece uma visão clara e consolidada dos clusters Kafka.
- Permite a inspeção de mensagens e tópicos, o que é útil para depuração e análise de dados em tempo real.
- Torna o Kafka mais acessível a desenvolvedores e operadores que podem não estar familiarizados com a administração via linha de comando.

Para mais informações sobre o Kafka UI, você pode visitar o site oficial.
https://docs.kafka-ui.provectus.io/


~~~
oc apply -f kafkaui/kafkaui.yaml
echo $(oc get route kafkaui -o jsonpath='{.spec.host}')
~~~
