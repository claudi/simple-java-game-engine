SRC = src/
SRCS := $(wildcard $(SRC)*.java)
BIN = bin/

.PHONY: run
run: $(BIN)GameFrame.class
	java -cp $(BIN) GameFrame

$(BIN)%.class: $(SRCS)
	javac -d $(BIN) $^

