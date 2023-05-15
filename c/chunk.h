#ifndef clox_chunk_h
#define clox_chunk_h

#include "common.h"
#include "value.h"

typedef enum {
	OP_CONSTANT,
	OP_RETURN,
} Opcode;

// TODO: run-length encode the 'lines' field
typedef struct {
	int count;
	int capacity;
	uint8_t* code; // a bytes array wrapper
	int* lines; // an array parallels the bytecode, encode line number info
	ValueArray constants;
} Chunk;

void initChunk(Chunk* chunk);

// Append a byte at the end of the chunk
void writeChunk(Chunk* chunk, uint8_t byte, int line);

void freeChunk(Chunk* chunk);

// Return the index where the constant was appended
int addConstant(Chunk* chunk, Value value);

#endif
