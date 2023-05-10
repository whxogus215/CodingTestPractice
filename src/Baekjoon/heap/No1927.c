#include <stdio.h>

#define TRUE 1
#define FALSE 0

typedef int HData;

typedef int PriorityComp(HData d1, HData d2);

typedef struct _heap {
	PriorityComp * comp;
	int numOfData;
	HData heapArr[100001];
} Heap;

void HeapInit(Heap * ph, PriorityComp pc){
	ph->numOfData = 0;
	ph->comp = pc;
}

int HIsEmpty(Heap * ph){
	if(ph->numOfData == 0)
		return TRUE;
	return FALSE;	
}

int GetParentIDX(int idx){
	return idx/2;
}

int GetLChildIDX(int idx){
	return idx*2;
}

int GetRChildIDX(int idx){
	return GetLChildIDX(idx)+1;
}

int GetHiPriChildIDX(Heap * ph, int idx){
	if(GetLChildIDX(idx) > ph->numOfData) return 0;
	else if(GetLChildIDX(idx) == ph->numOfData) return GetLChildIDX(idx);
	else {
		if(ph->comp(ph->heapArr[GetLChildIDX(idx)],ph->heapArr[GetRChildIDX(idx)]) < 0)
			return GetRChildIDX(idx);
		else
			return GetLChildIDX(idx); 
	}
}

void HInsert(Heap * ph, HData data){
	int idx = ph->numOfData + 1;
	
	while(idx != 1){
		if(ph->comp(data, ph->heapArr[GetParentIDX(idx)]) > 0){
			ph->heapArr[idx] = ph->heapArr[GetParentIDX(idx)];
			idx = GetParentIDX(idx);
		}
		else {
			break;
		} 
	}
	
	ph->heapArr[idx] = data;
	ph->numOfData += 1; 
}

int HDelete(Heap * ph){
	if(ph->numOfData == 0) return 0;
	
	HData retData = ph->heapArr[1];
	HData lastElem = ph->heapArr[ph->numOfData];
	
	int parentIdx = 1;
	int childIdx;
	
	while(childIdx = GetHiPriChildIDX(ph, parentIdx)){
		if(ph->comp(lastElem, ph->heapArr[childIdx]) >= 0)
			break;
		
		ph->heapArr[parentIdx] = ph->heapArr[childIdx];
		parentIdx = childIdx;
	}
	
	ph->heapArr[parentIdx] = lastElem;
	ph->numOfData -= 1;
	return retData;
}

int DataPriorityComp(int data1, int data2){
	// ������ ������ �Լ��� ����� ��ȯ�� ���, ù ��° ������ �켱������ ���ٰ� �����Ǿ� ���� 
	return data2 - data1; // data1�� ���� ��� ��� ��ȯ -> �ּ� �� 
} 


int main(void){
	Heap heap;
	HeapInit(&heap, DataPriorityComp);
	
	int N,i;
	scanf("%d", &N);
	
	int input;
	for(i = 0; i < N; i++){
		scanf("%d", &input);
		if(input == 0){
			printf("%d\n", HDelete(&heap));
		} else {
			HInsert(&heap, input);
		}
	}
	
	return 0;
}
