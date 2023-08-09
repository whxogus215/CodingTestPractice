#include<bits/stdc++.h>
using namespace std; 

int m, n, k, arr[100][100], visited[100][100], x, y, x2, y2;
int cnt, ret;

const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};

vector<int> v;

void DFS(int y, int x){
	visited[y][x] = 1;
	ret += 1;
	
	for(int i = 0; i < 4; i++){
		int ny = y + dy[i];
		int nx = x + dx[i];
		
		if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
		if(visited[ny][nx] || arr[ny][nx] == 1) continue;
		DFS(ny, nx);
	}
	
	return ;
}


int main() {
	
	cin >> m >> n >> k;
	for(int i = 0; i < k; i++){
		// 직사각형 부분을 1로 채우기 : 나머지는 자동으로 0으로 초기화되기 때문
		cin >> x >> y >> x2 >> y2;
		for(int i = y; i < y2; i++){
			for(int j = x; j < x2; j++){
				arr[i][j] = 1;
			}
		}
	}
	
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(arr[i][j] == 0 && !visited[i][j]) {
				ret = 0;
				DFS(i, j);
				cnt++;
				v.push_back(ret);
			}
		}
	}
	
	sort(v.begin(), v.end());
	
	cout << cnt << "\n";
	for(int i : v) cout << i << " ";
	cout << "\n";
	
	return 0; 
}
