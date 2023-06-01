##
## by: https://github.com/Yassineelg
## mail: yassineelgherrabi@gmail.com
## created: 31/05/2023
##

COMP = javac
SRC_DIR = src
OUT_DIR = .
LIB_DIR = lib
JAVA_FILES = $(SRC_DIR)/*.java
JUNIT = $(LIB_DIR)/junit-4.12.jar
HAMCREST_CORE = $(LIB_DIR)/hamcrest-core-1.3.jar
FLAGS = -Xlint -Xlint:deprecation -g

all:
	$(COMP) $(FLAGS) -cp $(JUNIT):$(HAMCREST_CORE) -d $(OUT_DIR) $(JAVA_FILES)

test:	all
	java -cp .:$(JUNIT):$(HAMCREST_CORE) org.junit.runner.JUnitCore GlobalConverterTest

clean:
	rm -rf $(OUT_DIR)/*.class

re: clean all

.PHONY: all clean re