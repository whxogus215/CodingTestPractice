#include <bits/stdc++.h>
using namespace std;
int arr[9];

int main(){
	
	/*
		1. �������� ������ ���� ������ ���Ѵ�. (next_permutation)
		2. ���ʺ��� 7���� ���ؼ� 100�� ���� ������ �����Ѵ�.
		3. 100�� ���� ��쿡 ���� ������ ����Ѵ�. 
	
	*/	
	
	for(int i = 0; i < 9; i++){
		cin >> arr[i];
	}
	
	sort(arr,arr+9);
	
	do{
		int sum = 0;
		for(int i = 0; i < 7; i++) sum += arr[i];
		
		if(sum == 100) break;
	
	}while(next_permutation(arr,arr+9));
	
	for(int i = 0; i < 7; i++) cout << arr[i] << "\n";
	
	return 0;
}
