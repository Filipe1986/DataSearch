

netstat -ano | findstr 8080
taskkill //F //PID 10440

//liquibase
liquibase --changelog-file=master-local.xml update-sql
