#include <bits/stdc++.h>
using namespace std;
string input;
int ret;

int main(){
	
	getline(cin, input);
	
	for(int i = 0; i < input.size(); i++){
		if(input[i] == ' ') continue;
		ret = input[i] + 13;
		
		if(input[i] >= 65 && input[i] <= 90){ // 대문자일때 
			if(ret > 90) input[i] = ret - 26;
			else input[i] += 13;
		} else if(input[i] >= 97 && input[i] <= 122){ // 소문자일때 
			if(ret > 122) input[i] = ret - 26;
			else input[i] += 13;
		}
	}
	
	cout << input;

	return 0;
}
