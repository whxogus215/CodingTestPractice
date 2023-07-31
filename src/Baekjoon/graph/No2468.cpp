#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int N, input, ret1, ret2, arr[101][101], ny, nx;
int visited[101][101];
int ret = -1;

void DFS(int y, int x){
	if(visited[y][x]) return;
	
	visited[y][x] = 1;
	for(int i = 0; i < 4; i++){
		ny = y + dy[i];
		nx = x + dx[i];
		
		if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
		if(arr[ny][nx] > ret) DFS(ny, nx);
	}
	
	return ;
}


int main(){
	
	cin >> N;
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			cin >> arr[i][j];
			ret = max(ret, arr[i][j]);
		}
	}
	
	while(ret--){
		ret1 = 0;
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(arr[i][j] > ret && !visited[i][j]) {
					DFS(i, j);
					ret1++;
				}
			}
		}
		
		ret2 = max(ret2, ret1);
		
		memset(visited, 0, sizeof(visited)); 
	}
	
	cout << ret2;
	
	
	
	return 0;
}


