<#macro	genInsertOrUpdateSql table primaryKeysString columnsString>
			<#local primaryKeys=primaryKeysString?trim?split('[,\\s]+','r')/>
			<#local columns=columnsString?trim?split('[,\\s]+','r')/>
			
			INSERT INTO ${table}(
				${primaryKeysString},${columnsString}
			)
			VALUES 
			(
				<#list primaryKeys as item>
					<#if item == 'tdate'>IFNULL(:${item},'1980-01-01')<#else>IFNULL(:${item},'*')</#if>,
				</#list>
				<#list columns as item>
					:${item}<#if item_has_next>,</#if>
				</#list>
			)
			ON DUPLICATE KEY UPDATE
				<#list columns as item>
					${item}=values(${item})<#if item_has_next>,</#if>
				</#list>
</#macro>

