#include<bits/stdc++.h>
using namespace std;

int N, M, ret, arr[51][51], result = 10500 ;

int mn = 1500;
vector<pair<int, int>> _home, chicken;
vector<vector<int>> chickenList;

void combi(int start, vector<int> v){
	if(v.size() == M) {
		chickenList.push_back(v);
		return; 
	}
	
	for(int i = start + 1; i < chicken.size(); i++){
		v.push_back(i);
		combi(i, v);
		v.pop_back();
	}
	return;
}

int main() {
	
	/*
	1. 맵 입력을 받으면서 치킨집, 집에 대한 좌표 값을 저장한다.
	2. 치킨집 좌표에 대한 조합을 뽑는다.
	3. 각 조합마다 도시의 치킨거리를 구하는 로직을 수행한다.
	*/
	
	cin >> N >> M;
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			cin >> arr[i][j];
			if(arr[i][j] == 1) _home.push_back({i,j});
			if(arr[i][j] == 2) chicken.push_back({i, j});
		}
	}
	
	vector<int> v;
	combi(-1, v);
	// chickList에 M개의 치킨집에 대한 조합이 저장된 상태
	for(vector<int> cList : chickenList){ // 각각의 조합별로 
		int ret = 0;
		// 각 집 마다 치킨집 조합에 대한 치킨 거리를 구한다
		for(pair<int, int> home : _home) {
			int _min = 105;
			for(int ch : cList) { // cList는 특정 치킨집 조합이며, 해당 조합에 대한 치킨 거리를 계산 
				int _dist = abs(home.first - chicken[ch].first) + abs(home.second - chicken[ch].second);
				_min = min(_min, _dist); // M 개의 치킨 집 중에서 가장 가까운 거리 계산 
			}
			ret += _min; // ret은 각 집에 대한 치킨 거리의 총합 : 특정 조합에 대한 도시의 치킨 거리 
		}
		result = min(result, ret); 
	}
	
	cout << result << "\n";
	
	return 0; 
}
