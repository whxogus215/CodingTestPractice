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
	// next_permutation �Լ��� �Է¹��� ������ �ش��ϴ� �迭�� ������ ���� ��, ���� �� ������ True, ������ False�� ��ȯ�Ѵ�. - while���� ����ϴ� ����
	// do-while���� ���� ���� ����� �ϴ� ������ ���ĵ� �迭�� �ϳ��� �����̱� �����̴�.
	// next_permutation �Լ��� ����ϱ� ���ؼ��� ������������ ���ĵ� �迭�� ����ؾ� �Ѵ�.	
	
	
	return 0;
}
