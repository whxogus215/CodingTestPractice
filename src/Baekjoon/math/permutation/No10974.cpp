#include <bits/stdc++.h>
using namespace std;
int main(){
	int N;
	cin >> N;
	int arr[N];
	
	for(int i = 0; i < N; i++){
		arr[i] = i+1;
	}
	
	sort(arr, arr + N);
	
	do{
		for(int i : arr) cout << i << " ";
		cout << "\n";
	}while(next_permutation(arr, arr + N));
	// next_permutation 함수는 입력받은 범위에 해당하는 배열의 순열을 만든 뒤, 만들 수 있으면 True, 없으면 False를 반환한다. - while문을 사용하는 이유
	// do-while문을 통해 먼저 출력을 하는 이유는 정렬된 배열도 하나의 순열이기 때문이다.
	// next_permutation 함수를 사용하기 위해서는 오름차순으로 정렬된 배열을 사용해야 한다.	
	
	
	return 0;
}
