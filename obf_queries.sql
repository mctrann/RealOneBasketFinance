#1)
select * from Person p
join EmailAddress e on p.personID = e.personID
join Address a on p.personID = a.personID;

#2)
