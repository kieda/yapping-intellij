# yapping-intellij
Intellij Plugin for the Yapping Language

### Note on path segments
Path segments are concatable, and represented by placing multiple values together with no whitespace

Example path segments:
```
1)  abc`[0-9]+`"literal"
2)  "list."variable
3)  `~<`(list.length.`~/2`)
```

To disambiguate, in the case where we have a path segment consisting of a single name
`x.variable` is equivalent to `x."variable"`. To denote that we may want to use a variable in
this case, we denote `x.(variable)`. Note that `x.variable"VAL"` may substitute `variable` and append
it to `"VAL"`. 

We don't perform this substitution when the path segment consists of a single name, 
as to ensure packages and filepaths work in a natural manner. 
```
import:
   # even if variable is defined, the following are not substituted
   !com.variable.MyPlugin  # looks in package com.variable
   @com/variable/MyPlugin  # looks in folder com/variable
   @"com"/variable/MyPlugin # == @"com"/"variable"/"MyPlugin"
   @"com/variable"/MyPlugin # equivalent to above
   @com/"variable/MyPlugin" # equivalent to above
   @"com/variable/MyPlugin" # equivalent to above
   @`(com|org)`/variable/MyPlugin # regexes work the same as literals
```

However we do have methods to ensure a variable may be substituted, and using `!yapping/vars.yah -VARSAFE` 
will ensure that a variable must be defined and substituted for names (or fail otherwise)
```
import: 
   @com/(variable)/MyPlugin # this is explicit, variable may be substituted
   @"com/"variable/MyPlugin # variable may be substituted
   @"com/"variable"/MyPlugin" # same as above
   @"com/variable/"MyPlugin   # MyPlugin may be substituted
   @"com/variable/My"Plugin   # Plugin may be substituted
```

Here are some examples where we explictly may use substitution if `variable` is defined:
```
section: 
  x."VAL"variable
  x.""variable
  x.variable""
```


Note that this rule is only applied when we're applying a scope operator. 
A single name will be substituted if it's not a path, e.g. 
```
import:
    variable = x                 # will substitute x 
    !com.(variable.field).Plugin # will resolve variable, however field will not be substituted
                                 # as it's a single name after scope operator
    @folder/(variable.field)/Plugin # note we switch to "." as we're now in a yapping type
    @folder/(subfolder/folder2)/Plugin # this fails - subfolder interpreted as a yapping type
    @folder/("subfolder/folder2")/Plugin # this works
    @folder/(@subfolder/folder2)/Plugin # this also works
    
    !com.(undefined.field).Plugin # this fails - undefined does not have field
    !com.[undefined, variable].Plugin # this is OK - resolves to [com.undefined.Plugin, com.(x).Plugin]
```

This sets us up for some interesting features
```
import: 
    @yapping/getentries.yah
    # results in @folder/subfolder/a.yah, @folder/subfolder/b.yah, but not @folder/subfolder/cc.yah
    @folder/:getentries: @subfolder filter: name  name.len.`~<5` return: "subfolder/"name;
    # results in @folder/subfolder/plugin.yah, @folder/subsubfolder/plugin.yah, ...
    @:getentries: @folder filter: name  `(sub)+`folder return: @folder/(name)/plugin.yah;
```


Using a folder that has a `/` in it

Escape the string
```
import: 
    @folder/"my\/name".yah
    @folder/`.*\/name`.yah
```
Note that this cannot happen for java and yapping type scopes, so `.` cannot be escaped in 
the same way.


