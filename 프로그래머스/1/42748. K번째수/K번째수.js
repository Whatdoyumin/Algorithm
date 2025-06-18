function solution(array, commands) {
    // commands -> i, j, k
        // 숫자 i번째부터 j번째까지 자르기.
        // 정렬하기
        // 배열의 k번째 숫자를 answer에 넣기
    
    var answer = [];
    var i = commands[0][0] - 1;
    var j = commands[0][1];
    var k = commands[0][2] - 1;
    
    arr2 = array.slice(i, j).sort();
    answer[0] = arr2.slice(k, k + 1);
    
    for(let n = 0; n < commands.length; n++) {
        var i = commands[n][0] - 1;
        var j = commands[n][1];
        var k = commands[n][2] - 1;

        arr2 = array.slice(i, j).sort((a, b) => a - b);
        answer[n] = arr2[k];
    }
    
    
    return answer;
}