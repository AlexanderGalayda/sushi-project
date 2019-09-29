<#import "parts/common.ftl" as c>
<@c.page>


List of user

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>

    </thead>
<tbody>
<#list user as userObj>
    <tr>
        <td>${userObj.username}</td>
        <td><#list userObj.roles as roleObj> ${roleObj}<#sep>, </#list></td>
        <td><a href="/user/${userObj.id}">Edit</a></td>

    </tr>

</#list>

</tbody>
</table>







</@c.page>