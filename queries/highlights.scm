;; queries/highlights.scm - Consolidated Tree-Sitter Highlight Queries

;; -----------------------------------------------------------------------------
;; Keywords & Operators
;; -----------------------------------------------------------------------------
["fn" "var" "let" "struct" "return" "if" "else"] @keyword

;; -----------------------------------------------------------------------------
;; Literals & Comments
;; -----------------------------------------------------------------------------
(string) @string
(number) @number
(line_comment) @comment

;; -----------------------------------------------------------------------------
;; Types & Built-ins
;; -----------------------------------------------------------------------------
(type_identifier) @type

((identifier) @type.builtin
  (#any-of? @type.builtin "Int" "Float32" "String" "Bool"))

;; -----------------------------------------------------------------------------
;; Function Declarations & Calls
;; -----------------------------------------------------------------------------
(function_declaration
  name: (identifier) @function)

(call_expression
  function: (identifier) @function.call)

;; -----------------------------------------------------------------------------
;; Variables, Constants & Special Identifiers
;; -----------------------------------------------------------------------------
(variable_declaration
  name: (identifier) @variable
  type: (type_identifier)? @type)

;; Match uppercase identifiers as constants
((identifier) @constant
  (#match? @constant "^[A-Z0-9_]+$"))

;; Special language built-ins
((identifier) @variable.builtin
  (#eq? @variable.builtin "self"))
