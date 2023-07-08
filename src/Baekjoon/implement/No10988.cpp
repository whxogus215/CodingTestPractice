#include<bits/stdc++.h>
using namespace std;

string input;
int ret = 1;

int main(){

	cin >> input;
	
	int num = input.length();
	
	
	for(int i = 0; i < num/2; i++){
		if(input[i] != input[num-i-1]) {
			ret = 0;
			break;
		}
	}
	
	
	
	
	cout << ret;
	
		
	return 0;
}

