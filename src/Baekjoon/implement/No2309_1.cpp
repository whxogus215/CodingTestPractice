#include <bits/stdc++.h>
using namespace std;
int arr[9];

int main(){
	
	/*
		1. 오름차순 정렬을 통해 순열을 구한다. (next_permutation)
		2. 왼쪽부터 7개씩 더해서 100이 나올 때까지 진행한다.
		3. 100이 나온 경우에 대한 수열을 출력한다. 
	
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
