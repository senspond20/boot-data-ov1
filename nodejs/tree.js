



//트리 변환 메서드
var treeModel = function (arrayList, rootId) {
	var rootNodes = [];
	var traverse = function (nodes, item, index) {
		if (nodes instanceof Array) {
			return nodes.some(function (node) {
				if (node.id === item.parentId) {
					node.children = node.children || [];
					return node.children.push(arrayList.splice(index, 1)[0]);
				}

				return traverse(node.children, item, index);
			});
		}
	};

	while (arrayList.length > 0) {
		arrayList.some(function (item, index) {
			if (item.parentId === rootId) {
				return rootNodes.push(arrayList.splice(index, 1)[0]);
			}

			return traverse(rootNodes, item, index);
		});
	}

	return rootNodes;
};

var model =[
    {id : 1, name :'개발',       parrent_id : 0, level: 1},
    {id : 2, name :'웹',         parrent_id : 1, level: 2},
    {id : 3, name :'하드웨어',   parrent_id : 1, level: 2},
    {id : 4, name :'프론트엔드', parrent_id : 2, level: 3},
    {id : 5, name :'백엔드',     parrent_id : 2, level :3},
    {id : 6, name :'일상',       parrent_id : 0, level : 1},
    {id : 7, name :'일기장',     parrent_id : 6, level : 2},
]

function getTreeData(array) {
    var map = {};
    for (var i = 0; i < array.length; i++) {
        var obj = {
            "id": array[i]['id'],
            "name": array[i]['name'],
            "level": array[i]['level']
        };
        obj.items = [];
        map[obj.id] = obj;
        var parent = array[i]['parrent_id'] || '-';

        if (!map[parent]) {
            map[parent] = {
                items: []
            };
        }
        map[parent].items.push(obj);
    }
    return map['-'].items;
}

// 관계형 데이터 베이스
// console.log(model)

// 트리 자료구조로 변환해서 넘겨줌 
var ddd = getTreeData(model);

// 
// console.log(ddd)
// ddd.forEach(function(e){
//     console.log(e.name)

//     console.log(e.items.name)
// })

function Category(id,name,parrent_id,level){
    this.id = id
    this.name = name
    this.parrent_id =parrent_id
    this.level = level
}

function getStr(data, arr){
    if(Array.isArray(data) && data.length !=0){
        data.forEach(function(e){
            arr.push(e.name)            
            var list = e.items;
            getStr(list,arr)
        })
    }
}

var arr = [];
getStr(ddd, arr);
console.log(arr)

var objj = new Category(1,'테스트','1',1);

console.log(objj)