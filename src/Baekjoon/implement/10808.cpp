#include <bits/stdc++.h>
using namespace std;

string str;
int arr[26];

int main(){
	
	cin >> str;
	
//	for(int i = 0; i < str.length(); i++){
//		int idx = str[i] % 97;
//		arr[idx] += 1;
//	}

	for(char a : str){
		arr[a - 'a']++; // ��ǥ �����̵� : ['a']�� [97]�� �����. a�� �ƽ�Ű �ڵ�� 97 
	}
	
	for(int i : arr) cout << i << " ";
	
		
	return 0;
}
