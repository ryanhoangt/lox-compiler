#include "common.h"
#include "chunk.h"
#include "debug.h"
#include "vm.h"

int main(int argc, const char* argv[]) {
	initVM();

	Chunk chunk;
	initChunk(&chunk);

	int constIdx = addConstant(&chunk, 1.2); // add constant to value array 
	writeChunk(&chunk, OP_CONSTANT, 123);
	writeChunk(&chunk, constIdx, 123);
	
	constIdx = addConstant(&chunk, 3.4);
	writeChunk(&chunk, OP_CONSTANT, 123);
	writeChunk(&chunk, constIdx, 123);
	
	writeChunk(&chunk, OP_ADD, 123);

	constIdx = addConstant(&chunk, 5.6);
	writeChunk(&chunk, OP_CONSTANT, 123);
	writeChunk(&chunk, constIdx, 123);

	writeChunk(&chunk, OP_DIVIDE, 123);
  	writeChunk(&chunk, OP_NEGATE, 123);

	writeChunk(&chunk, OP_RETURN, 123);

	interpret(&chunk);

	freeVM();
	freeChunk(&chunk);

	return 0;
}

