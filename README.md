# restaurante-mesas
Sistema de gerenciamento de mesas. (POO)
* RF00 - Sistema deve permitir o cadastro de novas mesas, ultilizando os seguntes dados: identificador,numero de pessoas
* RF01 - O Sistema deve permitir o cadastro de novos clientes na fila sendo um deles o responsavel pela reserva. Para que a reserva seja realizada o cliente responsavel deve fornecer seu nome, telefone
* RF02 - O Sistema deve ter um sistema de fila inteligente com margem 1, ou seja dar prioridades à clientes cujo a quantidade de pessoas correspondem o valor exato da mesa. Exemplo:
    
      (1)   (2)   (3)   (4)
    |  2  |  3  |  3  |  4  | 
     
    01 - Liberou mesa para 3 -> (2)
    -- (1) é a proxima caso a diferença X ou se ele ja foi pulado Y vezes
    02 - Liberou mesa para 3 -> (1)
    03 - Liberou mesa para 2 -> Deixe livre.
    04 - Liberou mesa para 4 -> (4)
    -- (3) é a proxima caso a diferença X ou se ele ja foi pulado Y vezes
    05 - Liberou mesa pra 3 -> (3)

    X - DEFINODO PELO SISTEMA
    Y - DEFINIDO PELO SISTEMA

    




