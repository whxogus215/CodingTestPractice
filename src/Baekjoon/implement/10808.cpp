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
		arr[a - 'a']++; // 좌표 평행이동 : ['a']는 [97]로 변경됨. a의 아스키 코드는 97 
	}
	
	for(int i : arr) cout << i << " ";
	
		
	return 0;
}
