# Problem 15: Library Reservation System


class BookDetails:
    def __init__(self, copies):
        self.total_copies = copies
        self.available = copies
        self.waitlist = []

class LibrarySystem:
    def __init__(self):
        self.books = {}

    def add_book(self, title, copies):
        self.books[title] = BookDetails(copies)
        print('Book "' + title + '" added with', copies, 'copies.')

    def borrow(self, user, title):
        book = self.books[title]

        if book.available > 0:
            book.available = book.available - 1
            print(user, 'borrows "' + title + '".')
        else:
            book.waitlist.append(user)
            print('no copies. ' + user + ' added to waitlist.')

    def return_book(self, user, title):
        book = self.books[title]

        if len(book.waitlist) > 0:
            next_user = book.waitlist.pop(0)
            print(user, 'returned. Assigned immediately to', next_user + '.')
            print('Copies available:', book.available)
        else:
            book.available = book.available + 1
            print(user, 'returned. No waitlist.')
            print('Copies available:', book.available)

    def show_book(self, title):
        book = self.books[title]
        print('Title:', title)
        print('Copies available:', book.available)
        print('Waitlist size:', len(book.waitlist))

library = LibrarySystem()

library.add_book("Dune", 1)

library.borrow("Dawit", "Dune")
library.borrow("Yohanse", "Dune")

library.return_book("Dawit", "Dune")
library.return_book("Yohanse", "Dune")

library.show_book("Dune")
