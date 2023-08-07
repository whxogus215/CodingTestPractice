#include<bits/stdc++.h>
using namespace std; 

int N, M, arr[51][51];
int minDist = 987654321; // 도시의 치킨 거리 최소 값 (비교를 위한 초기 값) 

vector<pair<int, int>> home, chicken;
vector<vector<int>> chickenList;

void combi(int start, vector<int> v){
	if(v.size() == M) {
		chickenList.push_back(v);
		return ;
	}
	
	for(int i = start + 1; i < chicken.size(); i++){
		v.push_back(i);
		combi(i, v);
		v.pop_back();
	}
	
	return;
}

int main() {
	
	cin >> N >> M;
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			cin >> arr[i][j];
			if(arr[i][j] == 1) home.push_back({i,j});
			if(arr[i][j] == 2) chicken.push_back({i,j});
		}
	}
	
	// 조합 뽑아서 chickenList에 저장하기
	vector<int> v;
	combi(-1, v);
	
	// 각 조합마다 도시의 치킨 거리 구하기 : chickenList에서 각각의 조합을 꺼낸다
	for(vector<int> cList : chickenList){
		// home에서 하나씩 꺼내서 계산
		int total = 0; // 특정 조합에 대한 도시의 치킨 거리를 저장하는 변수 
		for(pair<int, int> _home : home){
			int _min = 987654321;
			// 특정 집에 대해서 치킨 집마다 거리 구하기 : cList에 담겨 있는 치킨 집의 좌표를 하나씩 꺼내서 계산
			for(int c : cList){
				int distance = abs(_home.first - chicken[c].first) + abs(_home.second - chicken[c].second);
				_min = min(_min, distance); // 특정 치킨 조합에 대한 한 집의 치킨 거리(최소값) 
			}
			total += _min; // 각 집의 치킨 거리를 더해서 특정 조합에 대한 도시의 치킨 거리 계산 
		}
		minDist = min(minDist, total);
	}
	
	cout << minDist << "\n"; 
	
	return 0; 
}
