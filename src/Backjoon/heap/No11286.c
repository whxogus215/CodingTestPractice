#include <stdio.h>

typedef int PriorityComp(int d1, int d2);

typedef struct _heap
{
	PriorityComp * comp;
	int numOfData;
	int heapArr[100001];
} Heap;

void HeapInit(Heap * ph, PriorityComp pc)
{
	ph->numOfData = 0;
	ph->comp = pc;
}

int HIsEmpty(Heap * ph)
{
	if(ph->numOfData == 0)
		return 1;
	else
		return 0;
}

int GetParentIDX(int idx) 
{ 
	return idx/2; 
}

int GetLChildIDX(int idx) 
{ 
	return idx*2; 
}

int GetRChildIDX(int idx) 
{ 
	return GetLChildIDX(idx)+1; 
}

int Absolute(int data){
	if(data < 0) return data * -1;
	return data;
}

// �� �ڽ� ��� �� �켱���� ���� �ڽ��� �ε��� ��ȯ�ϴ� �Լ� 
int GetHiPriChildIDX(Heap * ph, int idx)
{
	if(GetLChildIDX(idx) > ph->numOfData)
		return 0;

	else if(GetLChildIDX(idx) == ph->numOfData)
		return GetLChildIDX(idx);

	else
	{
		if(ph->comp(ph->heapArr[GetLChildIDX(idx)], 
					ph->heapArr[GetRChildIDX(idx)]) < 0)
			return GetRChildIDX(idx);
		else
			return GetLChildIDX(idx);
	}
}

void HInsert(Heap * ph, int data)
{
	int idx = ph->numOfData+1; // ���� �ε����� 1���� �����ؼ� numOfData���� ����(���ǻ�) 

	while(idx != 1)
	{
	//	if(pr < (ph->heapArr[GetParentIDX(idx)].pr))
		if(ph->comp(data, ph->heapArr[GetParentIDX(idx)]) > 0)
		{
			ph->heapArr[idx] = ph->heapArr[GetParentIDX(idx)];
			idx = GetParentIDX(idx);
		}
		else
		{
			break;
		}
	}
	
	ph->heapArr[idx] = data;
	ph->numOfData += 1;
}

int HDelete(Heap * ph)
{
	if(ph->numOfData == 0) return 0;
	
	int retData = ph->heapArr[1];
	int lastElem = ph->heapArr[ph->numOfData];

	int parentIdx = 1;
	int childIdx;

	while(childIdx = GetHiPriChildIDX(ph, parentIdx))
	{
		if(ph->comp(lastElem, ph->heapArr[childIdx]) >= 0)
			break;

		ph->heapArr[parentIdx] = ph->heapArr[childIdx]; // lastElem�� �켱������ ���� ���, childIdx�� ���� ���� �÷��ִ� �۾� 
		parentIdx = childIdx;
	}

	ph->heapArr[parentIdx] = lastElem;
	ph->numOfData -= 1;
	return retData;
}

int DataPriorityComp(int data1, int data2){	
	// data1�� �켱������ ������ ��� ��ȯ
	if(Absolute(data1) < Absolute(data2)){
		return 1;
	} else if(Absolute(data1) == Absolute(data2)){
		if(data1 < data2) return 1;
		else return -1;
	}
	return -1;
}

int main(void){

	Heap heap;
	HeapInit(&heap, DataPriorityComp); // �� ���� 
	
	int N = 0;
	scanf("%d", &N);
	int i, input;
	for(i = 0; i < N; i++){
		// �Է��� ���� ���� ���� 
		scanf("%d", &input);
		if(input == 0) printf("%d\n", HDelete(&heap));
		else {
			HInsert(&heap, input);
		}
	}

	return 0;
}
