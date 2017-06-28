INSTALL CENTOS7 everything, but check only server with gui with nothing inside


POSTGRES SQL http://tecadmin.net/install-postgresql-9-5-on-centos/#
-----------------------------------------------------------------------------

rpm -Uvh http://yum.postgresql.org/9.5/redhat/rhel-7-x86_64/pgdg-centos95-9.5-2.noarch.rpm

yum install postgresql95-server postgresql95

sudo /usr/pgsql-9.5/bin/postgresql95-setup initdb

sudo systemctl start postgresql-9.5.service 
sudo systemctl enable postgresql-9.5.service 



-----------------------------------------------------------------------------

