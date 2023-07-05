#include <bits/stdc++.h>
using namespace std;
int arr[9], sum;
vector<int> v;
pair<int, int> ret;

void solve(){
	for(int i = 0; i < 9; i++){
		for(int j = 0; j < i; j++){
			if(sum - arr[i] - arr[j] == 100){
				ret = {i,j};
				return ;
			}
		}
	}
}

int main(){
	
	/*
		1. 9개 중에서 2개를 뽑는다. (Combination)
		2. 2개 중에서 (총합 - 100)을 만족하는 조합을 찾는다. 
	*/	
	
	for(int i = 0; i < 9; i++){
		cin >> arr[i];
		sum += arr[i];
	}
	
	solve();
	
	for(int i = 0; i < 9; i++){
		if(i == ret.first || i == ret.second) continue;
		v.push_back(arr[i]);
	}
	
	sort(v.begin(), v.end());
	for(int i : v) cout << i << "\n";
	
	return 0;
}
