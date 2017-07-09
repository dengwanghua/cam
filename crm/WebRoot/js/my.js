function loadSelect(typecode,positionId,selectname,selectedId){
	//1 创建select对象,将name属性指定
	var $select =  $("<select name="+selectname+"></select>");
	//2 添加提示选项
	$select.append($("<option value=''>---请选择---</option>"));
	//3 使用jquery 的ajax 方法,访问后台Action
	$.post("${pageContext.request.contextPath}/BaseDictAction",{ dict_type_code:typecode},
	  function(data){

	   		$.each( data, function(i, json){
	   			var $option = $("<option value='"+json['dict_id']+"' >"+json["dict_item_name"]+"</option>"); 
	   			
			if(json['dict_id'] == selectedId){
			
				$option.attr("selected","selected");
			}
		
				$select.append($option);
	   		});
	  },"json");
	$("#"+positionId).append($select);
}