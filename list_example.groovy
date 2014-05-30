List datastores = [ ["name":"name1"], ["name":"name2"], ["name":"name3"] ]
List names = datastores.collect { it.name }

println names
