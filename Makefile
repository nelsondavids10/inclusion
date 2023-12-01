clean:
	mvn clean

compile:
	mvn compile

test:
	mvn test

install:
	mvn clean install

site:
	mvn site -Psite

doc:
	mvn javadoc:javadoc

package:
	mvn package
