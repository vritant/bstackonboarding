set BSTACKPASS, BSTACKEMAIL and BSTACKURL as env variables

How to run:
mvn -Dbstack.passwd="$BSTACKPASS" -Dbstack.email="$BSTACKEMAIL" -Dsite.url="$BSTACKURL" -Pchrome,nogrid,Bstack clean install

for tests without browserstack, on local browser or remote grid, checkout : [without-bstack-master](bstackonboarding/tree/without-bstack-master)