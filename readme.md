set BSTACKPASS, BSTACKEMAIL and BSTACKURL as env variables
# chrome no grid
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pchrome,nogrid,Bstack clean install
# firefox no grid
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pfirefox,nogrid,Bstack clean install
# remote grid
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pfirefox,grid,Bstack clean install
