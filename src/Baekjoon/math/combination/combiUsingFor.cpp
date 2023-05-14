#include <bits/stdc++.h>
using namespace std;

int n = 5, k = 3, a[5] = {1,2,3,4,5};

int main(){
	// 차례대로 출력 
	for(int i = 0; i < n; i++){
		for(int j = i + 1; j < n; j++){
			for(int k = j + 1; k < n; k++){
				cout << i << " " << j << " " << k << "\n";
			}
		}
	}
	
	// 차례대로 출력 X 
	for(int i = 0; i < n; i++){
		for(int j = 0; j < i; j++){
			for(int k = 0; k < j; k++){
				cout << i << " " << j << " " << k << "\n";
			}
		}
	} 	
	
	return 0;
}
