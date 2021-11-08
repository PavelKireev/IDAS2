<#import "/spring.ftl" as spring>
<#import "layout/empty.ftlh" as layout>

<#assign title = "Zdravotni System" />
<#assign description = "Sign In" />

<@layout.render title description>
<h1>Successful Login by ${authUser.user.jmeno!"Invalid Name"} ${authUser.user.prijmeni!"Invalid Lastname"}.</h1>
</@layout.render>