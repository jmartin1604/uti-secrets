### OpenShift Config Maps
| Name | Value |
| ------ | ------ |
| Name | ws-batch-to-backend-dbdiferido |
| Key | ws.batch.to.backend.dbdiferido.endpoint |
| Value | jdbc:mysql://bd-mysql-dev-v2.c6yd7q2qhj6x.us-east-1.rds.amazonaws.com:3306/transporte?allowPublicKeyRetrieval=false&useSSL=false |
| | |
| Name | ws-batch-processtransaccion |
| Key | ws.batch.processtransaccion.cronjob |
| Value | 0 */15 * * * * |
| | |
| Name | ws-uti-to-uti-getmerchant  |
| Key | ws.uti.to.uti.getmerchant.endpoint |
| Value | uti-getmerchant.diferido-dev.svc.cluster.local:8889/ws/uti/getmerchant |

### OpenShift Secrets
| Name | Value |
| ------ | ------ |
| Name | ws-batch-to-backend-dbdiferido-authentication |
| Key | username |
| Value | user_as_dev |
| Key | password |
| Value | T3ch_T3Am |

### Container processtransaction
| Name | Value |
| ------ | ------ |
| Name | AWS_DB_USERNAME |
| Key | ws-batch-to-backend-dbdiferido-authentication |
| Value | username |
| | |
| Name | AWS_DB_PASSWORD |
| Key | ws-batch-to-backend-dbdiferido-authentication |
| Value | password |
| | |
| Name | AWS_DB_URL |
| Key | ws-batch-to-backend-dbdiferido |
| Value | ws.batch.to.backend.dbdiferido.endpoint |
| | |
| Name | BATCH_EXECUTION_TIME |
| Key | ws-batch-processtransaccion |
| Value | ws.batch.processtransaccion.cronjob |
| | |
| Name | UTI_GETMERCHANT |
| Key | ws-uti-to-uti-getmerchant |
| Value | ws.uti.to.uti.getmerchant.endpoint |

### Template Parameters
| Name | Value |
| ------ | ------ |
| Nombre de la aplicacion | processtransaction |
| URL de bitbucket | https://bitbucket.org/VisaNet_TI/processtransaction.git |
| Branch | developer |
| Contexto del servicio | /processtransaction  |
| Git Secret | mdp-crios-bitbucket |
| Target Port | 8889 |
| URL de servicio | |
| Maven Arguments | package -DskipTests -Dfabric8.skip -e -B |
| CPU request | 0.05 |
| CPU limit | 0.5 |
| % Memoria utilizar | 200M |
| Memoria limit | 250M |