SRC = src/
BIN = bin/

.PHONY: run
run: $(BIN)GameFrame.class
	java -cp $(BIN) GameFrame

$(BIN)%.class: $(SRC)%.java
	javac -d $(BIN) $^
	
