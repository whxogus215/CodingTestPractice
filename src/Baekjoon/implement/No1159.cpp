#include <bits/stdc++.h>
using namespace std;

int n;
string input, ret;
int arr[26];

int main(){
	
	cin >> n;
	for(int i = 0; i < n; i++){
		cin >> input;
		// input의 첫 글자 추출 -> arr[첫 글자 - 97] += 1;
		arr[input[0] - 'a']++;
	}
	
	for(int i = 0; i < 26; i++){
		if(arr[i] >= 5) {
			ret += (i + 'a');
		}
	}
	
	if(ret.size()) cout << ret << "\n";
	else cout << "PREDAJA" << "\n";


	return 0;
}
