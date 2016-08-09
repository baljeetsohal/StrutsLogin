<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


  <head>
      <meta http-equiv="content-type" content="text/xhtml; charset=windows-1252" />
      <meta http-equiv="content-language" content="en-us" />
       <style type="text/css">
      body { font-size: 80%; font-family: 'Lucida Grande', Verdana, Arial, Sans-Serif; }
      ul#tabs { list-style-type: none; margin: 30px 0 0 0; padding: 0 0 0.3em 0; }
      ul#tabs li { display: inline; }
      ul#tabs li a { color: #42454a; background-color: #dedbde; border: 1px solid #c9c3ba; border-bottom: none; padding: 0.3em; text-decoration: none; }
      ul#tabs li a:hover { background-color: #f1f0ee; }
      ul#tabs li a.selected { color: #000; background-color: #f1f0ee; font-weight: bold; padding: 0.7em 0.3em 0.38em 0.3em; }
      div.tabContent { border: 1px solid #c9c3ba; padding: 0.5em; background-color: #f1f0ee; }
      div.tabContent.hide { display: none; }
    </style>
        <script type="text/javascript">
    //<![CDATA[

    var tabLinks = new Array();
    var contentDivs = new Array();

    function init() {

      // Grab the tab links and content divs from the page
      var tabListItems = document.getElementById('tabs').childNodes;
      for ( var i = 0; i < tabListItems.length; i++ ) {
        if ( tabListItems[i].nodeName == "LI" ) {
          var tabLink = getFirstChildWithTagName( tabListItems[i], 'A' );
          var id = getHash( tabLink.getAttribute('href') );
          tabLinks[id] = tabLink;
          contentDivs[id] = document.getElementById( id );
        }
      }

      // Assign onclick events to the tab links, and
      // highlight the first tab
      var i = 0;

      for ( var id in tabLinks ) {
        tabLinks[id].onclick = showTab;
        tabLinks[id].onfocus = function() { this.blur() };
        if ( i == 0 ) tabLinks[id].className = 'selected';
        i++;
      }

      // Hide all content divs except the first
      var i = 0;

      for ( var id in contentDivs ) {
        if ( i != 0 ) contentDivs[id].className = 'tabContent hide';
        i++;
      }
    }

    function showTab() {
      var selectedId = getHash( this.getAttribute('href') );

      // Highlight the selected tab, and dim all others.
      // Also show the selected content div, and hide all others.
      for ( var id in contentDivs ) {
        if ( id == selectedId ) {
          tabLinks[id].className = 'selected';
          contentDivs[id].className = 'tabContent';
        } else {
          tabLinks[id].className = '';
          contentDivs[id].className = 'tabContent hide';
        }
      }

      // Stop the browser following the link
      return false;
    }

    function getFirstChildWithTagName( element, tagName ) {
      for ( var i = 0; i < element.childNodes.length; i++ ) {
        if ( element.childNodes[i].nodeName == tagName ) return element.childNodes[i];
      }
    }

    function getHash( url ) {
      var hashPos = url.lastIndexOf ( '#' );
      return url.substring( hashPos + 1 );
    }

    //]]>
    </script>
    </head>
   <body onload="init()">


    <ul id="tabs">
      <li> <a href="welcome">Create User</a> </li>
      <li><a href="userlist">User list</a></li>
      
    </ul>
<div id="Create User" class="tabcontent"  >
 <div class="content" >
           <s:form action="register" validate="true">
           
           <s:textfield label="First Name" name="user.first" required="true" />
 
             <s:textfield label="Last Name" name="user.last"  />
           <s:select cssStyle="width:155px" list="{'IT','BPO','other'}"  name="user.dept" label="Department"/>
         
        <s:set name="isflag" value="flag"/>
         <s:if test="%{#isflag==false}">
	 <s:textfield id="email" label="Email"  name="user.email" maxlength="20"  required="true"/>
	 
</s:if>
<s:else>
    <s:hidden name="user.id"></s:hidden>
   <s:textfield id="email" label="Email" name="user.email" maxlength="20"  disabled="true" required="true"/>
    
</s:else>
          
           <s:password label="Password" name="user.pass" maxlength="10"  required="true"/>    
           <s:submit value="register"></s:submit>
           </s:form>
       </div> 
</div>

</body>
</html>