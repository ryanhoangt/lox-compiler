#include "common.h"
#include "chunk.h"
#include "debug.h"

int main(int argc, const char* argv[]) {
	Chunk chunk;
	initChunk(&chunk);

	int constIdx = addConstant(&chunk, 1.2); // add constant to value array 
	writeChunk(&chunk, OP_CONSTANT, 123);
	writeChunk(&chunk, constIdx, 123);

	writeChunk(&chunk, OP_RETURN, 123);

	disassembleChunk(&chunk, "test chunk");
	freeChunk(&chunk);

	return 0;
}

