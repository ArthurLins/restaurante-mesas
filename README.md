
# restaurante-mesas
Sistema de gerenciamento de mesas. (POO)
#
* RF00 - Sistema deve possuir um **CRUD** de mesas, utilizando os seguintes dados: identificador e numero de pessoas.

* RF 01 - O Sistema deve permitir a atribuição de um cliente (Sem qualquer dado nessesário) a mesa, caso  não haja  mesas disponiveis o sistema deverá incluir-lo na lista de espera com os seguintes dados: Nome, Telefone e Quantidade de pessoas.

* RF 01.1 - Quando o cliente for adicionado a lista de espera, deve ser gerado um código de identificação do cliente (**) no qual ele ira ser chamado (Ex: Reserva Numero: 81818)

* RF02 - O Sistema deve ter um sistema de fila inteligente com margem ***X***, ou seja dar prioridades à clientes cujo a quantidade de pessoas correspondem o valor exato da mesa. 
**Exemplo**:
 
		  (1)   (2)   (3)   (4)     -- Identificador
		-------------------------
		|  2  |  3  |  3  |  4  |   -- Fila (Quantidade de pessoas)
**Processo:**   
01. Liberou mesa para 3 -> **(2)**

* ***(1)** é a próxima caso a diferença ***X*** ou se ele já foi pulado ***Y*** vezes*

02. Liberou mesa para 3 -> **(1)**

03. Liberou mesa para 2 -> Deixe livre.

04. Liberou mesa para 4 -> **(4)**

* ***(3)** é a próxima caso a diferença ***X*** ou se ele ja foi pulado ***Y*** vezes*

05. Liberou mesa pra 3 -> **(3)**

***X*** - DEFINIDO PELO SISTEMA
***Y*** - DEFINIDO PELO SISTEMA

* RF03 - O sistema deve permitir a liberação de mesas.
* RF04 - O sistema deve possuir um sistema de gerenciamento de fila com as funções: chamar o próximo da fila, adicionar e remover da fila.
* RF05 - O sistema deve possuir uma tela de chamada onde exibirá o identificação do cliente (**) a ser chamado.