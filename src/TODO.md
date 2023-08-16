# ttd
### precedence
`()`, allow to be concatenated to path
### lists
`[,]`, allow to be concatenated to path
### decimals
`0.0` requires both beginning and end digits. `.1` and `1.` are invalid, as it may link
to another scope operator.  
can this be in a path?

`sadf0.0asdf`
`asdf.0.0.asdf`
no, this does not work. 
May only work with precedence `asdf.(0.0).asdf`. 
Case to think about: `asdf(0.1)asdf`

Would we want to allow us to do something like pass args like the following?
`MyGrid.filterabove.(3.5)` or `MyGrid.filterabove(3.5)` or `MyGrid.filterbetween[3.5, 4.5]`

Might be a conflict, as `MyGrid.filterbetween["a", "b"]` typically resolves to
`[MyGrid.filterbetweena, MyGrid.filterbetweenb]`

But it still may be useful to do something like `dictionary.wordsBetween["aardvark", "zebra"]`
Problem comes in for `x = dictionary.wordsBetween`, `x["aardvark", "zebra"]`

We may want to use first and ensure we use the same name, s.t. `x = dictionary.wordsBetween`
does not resolve. Will allow `wordsBetween` to act like an implementation function
that can allow us to intern strings and more like the following
https://openjdk.org/jeps/430



### quotients
May not be in a path, only works with precedence `sadf(3/4)asdf`, or `MyTree.getAbove.(3/4)`

Todo: see above. We should find out how we may be able to make this work by matching to a scope with 
a 

### pairs
Pairs only work with precedence

`"abc"x=a"abc"` will resolve to `("abc"x) = (a"abc")`

We need `"abc"(x=a)"abc"` to insert a pair here.

### maps
Works like lists
`asdf{a=b, c=d}`

We can use pairs or lists to match both key and value
`value.a{a=b, b=c}`

`value.a{a=b, b=c}"abc"`, so `value.{aaabc = b}`, `value.{ababc = c}`

`value.a{a=h, b=i}{c=j, d=k}`

`concat.map(A)and(B)` or `concat.[A, B]`

### properties
Properties must concat to a list, map, primitive, etc.

`asdf:section: value section2: value2 ;asdf`

