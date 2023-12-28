set BSTACKPASS, BSTACKEMAIL and BSTACKURL as env variables
# chrome no grid
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pchrome,nogrid,Bstack clean install
# firefox no grid
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pfirefox,nogrid,Bstack clean install
# local grid
start grid: java -jar selenium-server-4.16.1.jar standalone
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pchrome,grid,Bstack clean install
