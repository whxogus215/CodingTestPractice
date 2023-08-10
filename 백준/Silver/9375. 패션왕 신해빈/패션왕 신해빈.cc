#include<bits/stdc++.h>
using namespace std; 

int T, N;
string value, key;

int main() {
	
	cin >> T;
	
	while(T--){
		map<string, int> _map;
		cin >> N;
		for(int i = 0; i < N; i++){
			cin >> value >> key;
			_map[key]++;
		}
		
		long long ret = 1;
		for(auto it : _map) {
			ret *= ((long long)it.second + 1);
		}
		
		cout << ret - 1 << "\n";
	}
	
	return 0; 
}
