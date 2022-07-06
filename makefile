# 206945271
# naimgit
compile: bin
	javac -d bin -cp biuoop-1.4.jar src/*.java

run:
	java -cp biuoop-1.4.jar:bin Ass7Game

jar:
	jar -cfm ass7game.jar Manifest.mf -C bin .

bin:
	mkdir bin