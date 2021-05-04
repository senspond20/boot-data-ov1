/**
 * @param {*} id 
 * @param {*} name 
 * @param {*} parrent_id 
 * @param {*} level 
 */
function Category(id, name, parrent_id, level) {
    this.id = id
    this.name = name
    this.parrent_id = parrent_id
    this.level = level
};

/**
 * 
 */
const categoryList = [
    new Category(1, '개발', 0, 1),
    new Category(2, '웹', 1, 2),
    new Category(3, '하드웨어', 1, 2),
    new Category(4, '프론트엔드', 2, 3),
    new Category(5, '백엔드', 2, 3),
    new Category(6, '일상', 0, 1),
    new Category(7, '일기장', 6, 2)
];



console.log(categoryList)

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

console.log(getTreeData(categoryList))



function TreeNode(value) {
    this.value = value;
    this.chidren = [];
}

function getTree(list) {
    var map = {}
    for (var item of list) {
        item.items = [];
        map[item.id] = item;
        var parent = item.parrent_id || '-';
        if (!map[parent]) {
            map[parent] = {
                items: []
            };
        }
        map[parent].items.push(item);
    }
    return map['-'].items;
}

const treeData = getTree(categoryList);


console.log(treeData)



function getStr(data, arr){
    if(Array.isArray(data) && data.length !=0){
        data.forEach(function(e){
            arr.push(e)            
            var list = e.items;
            getStr(list,arr)
        })
    }
}


// var arr = [];
// gethtml(treeData, arr);
// console.log(arr)



 var html = '';
function getHtml(data){
    if(Array.isArray(data) && data.length !=0){
        // html += `<ul>\n`
        data.forEach(function(e){
            html += `${'  '.repeat(e.level-1)} L ${e.name}\n`       
            var list = e.items;
            if(list.length !=0){
                getHtml(list)
            }
        })
    }
}
getHtml(treeData);
console.log(html)

console.log(printTree(treeData))

function printTree(data){
    var root = '<ul>nodeRoot</ul>';
    var lvl = 1; //first lvl
    data.forEach(function(item){
        var li =`<li>node${lvl}</li>`
        li = li.replace(`node${lvl}`,`${item.name}(${lvl})`);
        root = root.replace(`nodeRoot`, li);
        var list = item.items;
        // recAppend(list,li,lvl)
    })
    // console.log(root)
    // recAppend(data,root,lvl)
    return root;
};

function recAppend(list, ele, lvl){
    if(list.length !=0){
        lvl++;
        var ul = document.createElement('ul');
        list.forEach(function(item){
            var li = document.createElement('li')
            var span = document.createElement('span');
            span.append(`${item.name}(${lvl})`);
            li.appendChild(span)
            ul.appendChild(li)
            var list = item.items;
            return recAppend(list, li,lvl);
        })
        ele.appendChild(ul);
    }
};



// function* getStr2(data){
//     if(Array.isArray(data) && data.length !=0){
//         data.forEach(function(e){
//             arr.push(e.name)            
//             var list = e.items;
//             yield ;
//         })
//     }
// }

// for(var item of getStr2(categoryList)){
//     console.log(item)
// }
