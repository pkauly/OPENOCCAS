cd /opt/share/openoccas/source/objectmanagement
javac -cp /opt/share/classpath/service.jar:/opt/share/classpath/objectManagement.jar *.java
cd ../service
javac -cp /opt/share/classpath/service.jar:/opt/share/classpath/objectManagement.jar *.java
cd ../processsimulation
javac -cp /opt/share/classpath/service.jar:/opt/share/classpath/objectManagement.jar *.java
cd ..
jar cf /opt/share/classpath/objectManagement.jar objectmanagement/*.class
jar cf /opt/share/classpath/service.jar service/*.class
jar cf /opt/share/classpath/processsimulation.jar processsimulation/*.class
rm service/*.class
rm objectmanagement/*.class
rm processsimulation/*.class
